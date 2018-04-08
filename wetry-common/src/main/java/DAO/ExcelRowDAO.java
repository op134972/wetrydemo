package DAO;

public interface ExcelRowDAO {

    /**
     * 对于每一列写一个方法进行查询
     * 1、不同的查询首先在不同的表，也可能在同一个表，可以将同一个表的列进行封装，但是这样后续扩展性还没有一个列一个方法一个SQL语句扩展性强
     * 2、不同的列甚至可能在不同的库，需要将DAO.xml文件配置在不同的文件夹（不同文件夹对应的spring-mybatis配置不同，主要就是库的不同）
     * 3、这就要求，需要将不同的库的dao类也分离开来
     * 4、按照这样的思路，首先应该确定，
     *          1、每个列需要查询哪个表。
     *          2、对应的表在哪个库
     *          3、将相同的库的列的查询放到一个dao
     *          4、一个方法对应一个列
     */
    String getNameByUserId(String id);

    String getIdCardNumById(String id);

    String getNickNameById(String id);

    String getResumeUrlById(String id);

    int getClaimCountByGeekID();
}
