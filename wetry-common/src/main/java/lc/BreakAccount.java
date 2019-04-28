package lc;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * Created by tangwc on 2019/3/13.
 */
@Data
public class BreakAccount {

    static final int 北京 = 1;
    static final int 上海 = 2;
    static final int 广州 = 3;
    static final int 深圳 = 4;

    @Data
    static class Account {
        int limit;
        int jobCount;
        Set<Integer> cities;

        @Override
        public String toString() {
            return "Account{" +
                    "limit=" + limit +
                    ", jobCount=" + jobCount +
                    ", cities=" + cities +
                    '}';
        }
    }

    @Data
    static class Job {
        Account account;
        int city;

        public Job(int city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "account=" + account +
                    ", city=" + city +
                    '}';
        }
    }

    @NoArgsConstructor
    @Data
    static class User {
        List<Account> accounts;
        List<Job> jobs;

        public boolean postJob(Job A) {
            if (accounts == null) {
                initAccount();
                sortByJobLimit(accounts);
            }
            /**
             * 因为不知道下一个发什么城市的职位，所以没有绝对的最优解，只能通过后期的修正来达到合理配置。
             * 1. 按城市遍历，列出所有相同城市的账号
             * 2. 多个账号取职位剩余多的，优先使用
             * 3. 如果所有账号这个城市的职位剩余为0,则需要修改之前发的职位的账号占用来挪位，由于线上账号配置的复杂，这一步可能会非常费。
             */
            boolean cityOk = false;
            boolean jobCountOk = false;
            for (Account account : accounts) {
                Set<Integer> cities = account.getCities();
                boolean currCityOk = cities.contains(A.getCity());
                cityOk |= currCityOk;
                boolean currJobOk = jobCountNotLimit(account);
                jobCountOk |= currJobOk;
                if (currCityOk && currJobOk) {
                    account.setJobCount(account.getJobCount() + 1);
                    //1.理想的情况，有对应城市，且还有剩余职位数
                    if (jobs == null) {
                        jobs = new ArrayList<>();
                    }
                    A.setAccount(account);
                    jobs.add(A);
                    return true;
                }
            }
            if (cityOk) {
                //2.说明有城市，没有职位数了
                /**
                 * 1. 这里和业务相联系，取boss上一个职位B，假设B是发的广州的，取出B对应的账号的城市集
                 * 2. 如果B对应账号有北京，且其他账号有广州，则将B移到其他账号
                 * 3. 如果没有北京，或者其他账号没有上海，取boss再往上一个职位，直到最后一个职位。
                 */
                for (Job B : jobs) {
                    Account accountB = B.getAccount();
                    Set<Integer> jCities = accountB.getCities();
                    if (!jCities.contains(A.getCity())) {
                        continue;
                    }
                    for (Account acc : accounts) {
                        if (acc == accountB) {
                            continue;
                        }
                        Set<Integer> otherAccountCities = acc.getCities();
                        if (otherAccountCities.contains(B.getCity()) && jobCountNotLimit(acc)) {
                            //B对应账号有北京，且其他账号有广州
                            //1.将B移到另外的账号
                            acc.setJobCount(acc.getJobCount() + 1);
                            B.setAccount(acc);
                            //2.将发布的当前职位移到B之前的账号
                            A.setAccount(accountB);
                            jobs.add(A);
                            return true;
                        }
                    }
                }
            }

            //3.没城市，无法发布职位。
            return false;
        }

        private boolean jobCountNotLimit(Account account) {
            return account.getLimit() > account.getJobCount();
        }

        private void sortByJobLimit(List<Account> accounts) {
            accounts.sort((o1, o2) -> o2.getLimit() - o1.getLimit());
        }

        private void initAccount() {
            accounts = new ArrayList<>();
            Account ac1 = new Account();
            ac1.setCities(city1);
            ac1.setLimit(3);
            Account ac2 = new Account();
            ac2.setCities(city2);
            ac2.setLimit(5);
            accounts.add(ac1);
            accounts.add(ac2);
        }

        @Override
        public String toString() {
            return "User{" +
                    "accounts=" + accounts +
                    ", jobs=" + jobs +
                    '}';
        }
    }

    static Set<Integer> city1 = new HashSet<>();
    static Set<Integer> city2 = new HashSet<>();

    static {
        city1.add(北京);
        city1.add(上海);
        city1.add(广州);

        city2.add(上海);
        city2.add(广州);
        city2.add(深圳);




    }

    /**
     * 现在产品要将账号关联城市类别，一个账号上限制了职位个数，  一个城市类别是多个城市的集合，不同城市类别城市可能有重复的
     * 举例  一个boss有两个账号，当前北京职位2个，上海3个
     * 账号1：有3个职位，城市类别：北京、上海
     * 账号2：有5个职位，城市类别：上海、广州
     * 这个时候 北京的消耗账号1的两个还剩1个，上海的可能有两种消耗：1：账号1消耗1个，账号2消耗2个；2：账号2消耗3个
     * 当boss再次发布一个北京的时候，上海的按第2中消耗才能发，按第一种消耗不能发
     */
    public static void main(String[] args) {
        User u = new User();
        System.out.println("北京"+u.postJob(new Job(北京)));
        System.out.println("广州"+u.postJob(new Job(广州)));
        System.out.println("上海"+u.postJob(new Job(上海)));
        System.out.println("广州"+u.postJob(new Job(广州)));
        System.out.println("北京"+u.postJob(new Job(北京)));
        System.out.println("北京"+u.postJob(new Job(北京)));
        System.out.println("北京"+u.postJob(new Job(北京)));
        System.out.println("上海"+u.postJob(new Job(上海)));
        System.out.println("北京"+u.postJob(new Job(北京)));
        System.out.println("深圳"+u.postJob(new Job(深圳)));
        System.out.println("北京"+u.postJob(new Job(北京)));
        System.out.println("深圳"+u.postJob(new Job(深圳)));
        System.out.println("北京"+u.postJob(new Job(北京)));
        System.out.println("北京"+u.postJob(new Job(北京)));
        System.out.println("上海"+u.postJob(new Job(上海)));
        System.out.println("上海"+u.postJob(new Job(上海)));
        System.out.println("上海"+u.postJob(new Job(上海)));
        System.out.println("广州"+u.postJob(new Job(广州)));
    }

}
