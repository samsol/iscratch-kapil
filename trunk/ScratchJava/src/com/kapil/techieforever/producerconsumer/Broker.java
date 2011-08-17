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

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Broker
{
    public ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(100);
    public Boolean continueProducing = Boolean.TRUE;

    public void put(Integer data) throws InterruptedException
    {
        this.queue.put(data);
    }
    
    public Integer get() throws InterruptedException
    {
        return this.queue.poll(10, TimeUnit.SECONDS);
    }
}
