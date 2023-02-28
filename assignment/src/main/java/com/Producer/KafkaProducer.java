package com.Producer;




import org.springframework.beans.factory.annotation.Autowired;

    @RestController
    @RequestMapping("/produce")
    public class KafkaProducer {

        @Autowired
        private KafkaTemplate<String, Object> kafkaTemplate;

        @PostMapping("/message")
        public String sendMessage(@RequestBody Animal message) {
            try {
                kafkaTemplate.send(ApplicationConstant.TOPIC_NAME, message);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "json message sent successfully";
        }

        @GetMapping("/message")
        public String getMessage() {
            return "GET request received successfully";
        }

        @PutMapping("/message")
        public String updateMessage(@RequestBody Animal message) {
            try {
                kafkaTemplate.send(ApplicationConstant.TOPIC_NAME, message);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "json message updated successfully";
        }

        @DeleteMapping("/message")
        public String deleteMessage() {
            return "json message deleted successfully";
        }
    }


