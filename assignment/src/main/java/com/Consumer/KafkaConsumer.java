package com.Consumer;


    import org.slf4j.Logger;

    @Component
    public class KafkaConsumer {

        private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

        @KafkaListener(groupId = ApplicationConstant.GROUP_ID_JSON, topics = ApplicationConstant.TOPIC_NAME, containerFactory = ApplicationConstant.KAFKA_LISTENER_CONTAINER_FACTORY)
        public void receivedMessage(Animal message) throws JsonProcessingException {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(message);
            logger.info("Json message received using Kafka listener " + jsonString);
        }
    }

