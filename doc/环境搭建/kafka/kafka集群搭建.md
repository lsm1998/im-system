参考链接：
https://blog.csdn.net/justlpf/article/details/127263928

安装kafka
````shell
cd /opt

yum install java-11-openjdk.x86_64 -y

wget https://downloads.apache.org/kafka/3.4.0/kafka_2.12-3.4.0.tgz

tar -xzf kafka_2.12-3.4.0.tgz

mv kafka_2.12-3.4.0 kafka-3.4.0

mkdir /opt/kafka-3.4.0/data
````

配置zookeeper.properties

````shell
vi /opt/kafka-3.4.0/config/zookeeper.properties

#主要是配置快照存放地址路径
dataDir=/opt/kafka-3.4.0/data
#端口号
clientPort=2181
maxClientCnxns=0
admin.enableServer=false
````

配置server.properties

````shell
mkdir /opt/kafka-3.4.0/kafka-logs
vi /opt/kafka-3.4.0/config/server.properties

#保证唯一
broker.id=0
num.network.threads=3
num.io.threads=8
socket.send.buffer.bytes=102400
socket.receive.buffer.bytes=102400
socket.request.max.bytes=419430400
#配置日志存放文件夹路径
log.dirs=/opt/kafka-3.4.0/kafka-logs
num.partitions=1
num.recovery.threads.per.data.dir=1
offsets.topic.replication.factor=1
transaction.state.log.replication.factor=1
transaction.state.log.min.isr=1
log.retention.hours=168
log.retention.check.interval.ms=300000
#zookeeper的地址和端口号
zookeeper.connect=192.168.239.200:2181
zookeeper.connection.timeout.ms=18000
group.initial.rebalance.delay.ms=0
````

启动kafka
    
````shell
cd /opt/kafka-3.4.0/bin

./zookeeper-server-start.sh -daemon ../config/zookeeper.properties

./kafka-server-start.sh -daemon ../config/server.properties
````