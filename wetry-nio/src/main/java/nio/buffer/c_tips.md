## Buffer

mark position limit capacity

API：

Buffer.allocate(capacity);

buffer.flip();//翻转 limit = position ,position = 0

buffer.rewind();// position = 0

buffer.clear();// position = 0,limit = position

buffer.get();
buffer.get(index);
buffer.put();
buffer.put(index);