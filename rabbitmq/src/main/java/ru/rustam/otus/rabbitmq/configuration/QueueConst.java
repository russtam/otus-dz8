package ru.rustam.otus.rabbitmq.configuration;

import lombok.experimental.UtilityClass;

@UtilityClass
public class QueueConst {

    public static final String FANOUT_EXCHANGE_POSTFIX = "-fx";
    public static final String FAIL_FANOUT_EXCHANGE = "FailFanout" + FANOUT_EXCHANGE_POSTFIX;
    public static final String ORDER_CREATED_QUEUE = "OrderCreatedQueue";
    public static final String ORDER_RESERVED_QUEUE = "OrderReservedQueue";
}
