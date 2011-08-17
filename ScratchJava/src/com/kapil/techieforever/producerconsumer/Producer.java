/*******************************************************************************
 * Copyright 2011 @ Kapil Viren Ahuja
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.kapil.techieforever.producerconsumer;

public class Producer implements Runnable
{
    private Broker broker;

    public Producer(Broker broker)
    {
        this.broker = broker;
    }


    @Override
    public void run()
    {
        try
        {
            for (Integer i = 1; i < 5 + 1; ++i)
            {
                System.out.println("Producer produced: " + i);
                Thread.sleep(100);
                broker.put(i);
            }
            
            this.broker.continueProducing = Boolean.FALSE;
            System.out.println("Producer finished its job; terminating.");
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }

    }
}
