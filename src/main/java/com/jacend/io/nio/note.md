核心
Channels
Buffers
Selectors

Channel 和 Buffer
基本上，所有的 IO 在NIO 中都从一个Channel 开始。
Channel 有点象流。 数据可以从Channel读到Buffer中，也可以从Buffer 写到Channel中。

主要 channel 的实现
FileChannel 文件 IO
DatagramChannel UDP
SocketChannel 能通过TCP读写网络中的数据
ServerSocketChannel 可以监听新进来的TCP连接，像Web服务器那样。对每一个新进来的连接都会创建一个SocketChannel。

主要 Buffer 的实现
ByteBuffer
CharBuffer
DoubleBuffer
FloatBuffer
IntBuffer
LongBuffer
ShortBuffer

Java NIO 还有个 MappedByteBuffer，用于表示内存映射文件， 我也不打算在概述中说明。

Selector
Selector允许单线程处理多个 Channel。如果你的应用打开了多个连接（通道），
但每个连接的流量都很低，使用Selector就会很方便。例如，在一个聊天服务器中。
要使用Selector，得向Selector注册Channel，然后调用它的select()方法。
这个方法会一直阻塞到某个注册的通道有事件就绪。
一旦这个方法返回，线程就可以处理这些事件，事件的例子有如新连接进来，数据接收等。


## Buffer
缓冲区本质上是一块可以写入数据，然后可以从中读取数据的内存。
这块内存被包装成NIO Buffer对象，并提供了一组方法，用来方便的访问该块内存。

capacity
position
limit

使用Buffer读写数据一般遵循以下四个步骤：
1. 写入数据到Buffer
2. 调用flip()方法
3. 从Buffer中读取数据
4. 调用clear()方法或者compact()方法

当向buffer写入数据时，buffer会记录下写了多少数据。一旦要读取数据，
需要通过flip()方法将Buffer从写模式切换到读模式。在读模式下，可以读取之前写入到buffer的所有数据。

一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入。
有两种方式能清空缓冲区：调用clear()或compact()方法。clear()方法会清空整个缓冲区。
compact()方法只会清除已经读过的数据。
任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未读数据的后面。

写数据到 Buffer 中有两种方式
1. 从 Channel 写到 Buffer
2. 通过 Buffer 的 put() 方法写到 Buffer

同样的 读数据也有两种方式
1. 从Buffer读取数据到Channel。
2. 使用get()方法从Buffer中读取数据。

Java NIO开始支持scatter/gather，scatter/gather用于描述从Channel
（译者注：Channel在中文经常翻译为通道）中读取或者写入到Channel的操作。 
分散（scatter）从Channel中读取是指在读操作时将读取的数据写入多个buffer中。
因此，Channel将从Channel中读取的数据“分散（scatter）”到多个Buffer中。
聚集（gather）写入Channel是指在写操作时将多个buffer的数据写入同一个Channel，
因此，Channel 将多个Buffer中的数据“聚集（gather）”后发送到Channel。

## channel