# CDC Streaming Publisher

**CDC Streaming Publisher** is an open-source project designed to enable Change Data Capture (CDC) with Debezium and publish those changes to a custom CDC stream publisher, decoupled from Kafka. It offers guaranteed delivery, clustering, sharding, high availability, and elastic scalability, supporting both **Spark** and **Flink** consumers directly. The architecture is built for distributed environments with horizontal scalability in mind.

## Features

- **Decoupled from Kafka**: Stream CDC events without tight integration with Kafka.
- **Guaranteed Delivery**: Ensures event delivery with at-least-once and exactly-once semantics.
- **Spark & Flink Integration**: Plugins for seamless consumption of CDC streams with Spark and Flink.
- **Clustered, Sharded, & Highly Available**: Supports horizontal scalability with clustering, sharding, and built-in high availability.
- **Elastic Scalability**: Scale with your application's growing needs without downtime.

## Architecture

The project is designed with the following core components:

1. **CDC Event Publisher**: Connects to Debezium for CDC streams and decouples the downstream system from Kafka.
2. **Consumer Plugin**: Allows Spark and Flink to consume CDC events directly from the custom consumer.
3. **Delivery Guarantees**: Implements robust delivery guarantees including at-least-once and exactly-once delivery semantics.
4. **Clustering and Sharding**: Distributes load across nodes for improved performance and fault tolerance.
5. **High Availability**: Ensures availability through redundancy and failover mechanisms.
6. **Elastic Scalability**: Scales horizontally with minimal operational overhead.

## Getting Started

### Prerequisites

Ensure you have the following installed:
- **Debezium** for capturing database changes.
- **Apache Spark** or **Apache Flink** for stream processing.
- **Java 11** or higher.
- **Docker** for running the CDC publisher and dependencies.

### Installation

Clone the repository:

```bash
git clone https://github.com/yourusername/cdc-streaming-publisher.git
cd cdc-streaming-publisher
