package cn.thinkingdata.kafka.consumer.persist;

import cn.thinkingdata.kafka.consumer.dao.KafkaConsumerOffset;

public interface OffsetPersist {
	
	abstract void persist(KafkaConsumerOffset kafkaConsumerOffsetInCache);
	
	abstract void shutdown();
	
	abstract Boolean flush(KafkaConsumerOffset kafkaConsumerOffsetInCache);
	
//	abstract void flush();
}
