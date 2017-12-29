package producerComsumerActiveObject;

/**
 * Created by jacek on 13.12.17.
 */
public interface IConsumersAndProducersManage {

    void startProducer();
    void deleteProducer(int id);
    void startConsumer();
    void deleteConsumer(int id);

}
