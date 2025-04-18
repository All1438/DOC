<!-- Lambda function are limited to 15 minutes in duration, but on average most calls take less than a second -->
# info
The event is a JSON object that contains all information about what happened
The first parameter of every Lambda handler function contains the event json object
An event could be custom-generated from another microservice or generated from existing AWS service

On peut écrire les code dans Lambda>Function>name_function>code
et les tests dans Lambda>Function>name_function>test

| **Pattern**                          | **Description**                                                                                 | **AWS Services**                                                                                   |
|--------------------------------------|-------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------|
| **Event Notification**               | Notifie les services en cas de changement ou d'événement.                                       | - Amazon S3 Event Notifications <br> - Amazon SNS <br> - Amazon EventBridge                      |
| **Event Streaming**                  | Diffuse en temps réel un flux continu d’événements.                                             | - Amazon Kinesis <br> - Amazon MSK (Managed Streaming for Apache Kafka)                          |
| **Event Filtering**                  | Filtre les événements pour s'assurer que seuls les intéressants sont transmis.                 | - Amazon EventBridge <br> - Amazon SNS                                                           |
| **Event Sourcing**                   | Stocke l’état de l’application sous forme de séquences d’événements immuables.                 | - Amazon DynamoDB <br> - Amazon S3 <br> - AWS Lambda                                             |
| **Publish/Subscribe (Pub/Sub)**      | Permet à plusieurs services de réagir indépendamment à un événement émis.                      | - Amazon SNS <br> - Amazon EventBridge                                                           |
| **Command Query Responsibility Segregation (CQRS)** | Sépare les commandes (writes) des requêtes (reads) pour optimiser la performance. | - Amazon DynamoDB <br> - Amazon SQS <br> - AWS Lambda                                            |
| **Fan-out**                          | Diffuse un événement unique à plusieurs destinataires.                                          | - Amazon SNS <br> - AWS Lambda <br> - Amazon SQS                                                 |
| **Dead Letter Queue (DLQ)**          | Gère les événements échoués pour une reprise ou une analyse ultérieure.                        | - Amazon SQS (DLQ) <br> - AWS Lambda DLQ                                                         |
| **Retry and Backoff**                | Gère les échecs temporaires avec des stratégies de re-tentatives et de délais progressifs.      | - AWS Lambda <br> - Amazon SQS <br> - Amazon Step Functions                                      |
| **Event Replay**                     | Permet de rejouer les événements pour débogage ou synchronisation entre services.              | - Amazon EventBridge Archive <br> - Amazon Kinesis Data Streams                                  |
| **Workflow Orchestration**           | Orchestration des services et des événements dans une séquence logique.                        | - AWS Step Functions <br> - Amazon SWF (Simple Workflow Service)                                 |
| **Message Queue**                    | Gère la communication asynchrone avec garantie de livraison.                                   | - Amazon SQS                                                                                     |
| **Edge Event Processing**            | Traite les événements en périphérie pour réduire la latence et la bande passante.              | - AWS IoT Core <br> - AWS Greengrass                                                             |
| **Event Mesh**                       | Connecte les producteurs et consommateurs d’événements sur un réseau distribué.                | - Amazon EventBridge <br> - Amazon MQ (Managed Message Broker for ActiveMQ and RabbitMQ)         |


# JSON
## Event S3
```JSON
{
  "Records": [
    {
      "eventVersion": "2.1",
      "eventSource": "aws:s3",
      "awsRegion": "us-west-2",
      "eventTime": "2025-01-17T15:30:00.123Z",
      "eventName": "ObjectCreated:Put",
      "userIdentity": {
        "principalId": "AWS:EXAMPLE"
      },
      "requestParameters": {
        "sourceIPAddress": "192.0.2.1"
      },
      "responseElements": {
        "x-amz-request-id": "EXAMPLE123456789",
        "x-amz-id-2": "EXAMPLE123456789EXAMPLE123456789"
      },
      "s3": {
        "s3SchemaVersion": "1.0",
        "configurationId": "example-config-id",
        "bucket": {
          "name": "example-bucket",
          "ownerIdentity": {
            "principalId": "EXAMPLE"
          },
          "arn": "arn:aws:s3:::example-bucket"
        },
        "object": {
          "key": "example-key/file.txt",
          "size": 1024,
          "eTag": "d41d8cd98f00b204e9800998ecf8427e",
          "sequencer": "0A1B2C3D4E5F678901"
        }
      }
    }
  ]
}
```

## Event SNS
```json
{
  "Type": "Notification",
  "MessageId": "b1234567-abcd-8901-ef23-456789abcdef",
  "TopicArn": "arn:aws:sns:us-west-2:123456789012:example-topic",
  "Subject": "File Uploaded",
  "Message": "A new file has been uploaded to the bucket.",
  "Timestamp": "2025-01-17T15:30:00.123Z",
  "SignatureVersion": "1",
  "Signature": "EXAMPLESIGNATURE",
  "SigningCertURL": "https://sns.us-west-2.amazonaws.com/SimpleNotificationService-bb750dd426d95ee9390147a5624348ee.pem",
  "UnsubscribeURL": "https://sns.us-west-2.amazonaws.com/?Action=Unsubscribe&SubscriptionArn=arn:aws:sns:us-west-2:123456789012:example-topic:example-subscription-id"
}
```


