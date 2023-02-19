package com.lsm1998.im.synchro;

public class App
{
    public static void main(String[] args)
    {
        public class MySQLToClickHouseSync
        {
            // 创建Flink执行环境
            StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

            // 配置MySQL数据源
            JdbcInputFormat jdbcInputFormat = JdbcInputFormat.buildJdbcInputFormat()
                    .setDrivername("com.mysql.jdbc.Driver")
                    .setDBUrl("jdbc:mysql://localhost:3306/test")
                    .setUsername("root")
                    .setPassword("")
                    .setQuery("SELECT * FROM mytable")
                    .setRowTypeInfo(new RowTypeInfo(
                            Types.STRING, Types.INT, Types.DOUBLE, Types.SQL_TIMESTAMP))
                    .finish();
            DataStreamSource<Row> mysqlStream = env.createInput(jdbcInputFormat);

            // 转换和处理数据
            DataStream<Tuple4<String, Integer, Double, Timestamp>> transformedStream = mysqlStream
                    .map(new MapFunction<Row, Tuple4<String, Integer, Double, Timestamp>>()
                    {
                        @Override
                        public Tuple4<String, Integer, Double, Timestamp> map(Row row) throws Exception
                        {
                            return Tuple4.of(row.getField(0).toString(),
                                    (Integer) row.getField(1),
                                    (Double) row.getField(2),
                                    (Timestamp) row.getField(3));
                        }
                    });

            // 配置ClickHouse输出格式
            ClickHouseOutputFormat<Tuple4<String, Integer, Double, Timestamp>> clickhouseOutputFormat =
                    ClickHouseOutputFormat.buildClickHouseOutputFormat()
                            .setDrivername("ru.yandex.clickhouse.ClickHouseDriver")
                            .setDBUrl("jdbc:clickhouse://localhost:8123/default")
                            .setUsername("default")
                            .setPassword("")
                            .setBatchSize(1000)
                            .setSql("INSERT INTO mytable (col1, col2, col3, col4) VALUES (?, ?, ?, ?)")
                            .finish();
                transformedStream.addSink(new JdbcOutputFormatSinkFunction<>(clickhouseOutputFormat));

            // 启动Flink作业
                env.execute("MySQLToClickHouseSync");
        }
    }
}
