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

public class Consumer implements Runnable
{

    private String name;
    private Broker broker;


    public Consumer(String name, Broker broker)
    {
        this.name = name;
        this.broker = broker;
    }


    @Override
    public void run()
    {
        try
        {
            Integer data = broker.get();

            while (broker.continueProducing || data != null)
            {
//                Thread.sleep(1000);
                System.out.println("Consumer " + this.name + " processed data from broker: " + data);

                data = broker.get();
            }


            System.out.println("Comsumer " + this.name + " finished its job; terminating.");
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }

}
