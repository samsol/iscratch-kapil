/*******************************************************************************
 * Copyright 2011 @ Kapil Viren Ahuja
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 ******************************************************************************/
package com.kapil.techieforever.producerconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestProducerConsumer
{

    public static void main(String args[])
    {
        try
        {
            Broker broker = new Broker();

            ExecutorService threadPool = Executors.newFixedThreadPool(3);


            threadPool.execute(new Consumer("1", broker));
            threadPool.execute(new Consumer("2", broker));
            Future producerStatus = threadPool.submit(new Producer(broker));

            // this will wait for the producer to finish its execution.
            producerStatus.get();
            

            threadPool.shutdown();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
