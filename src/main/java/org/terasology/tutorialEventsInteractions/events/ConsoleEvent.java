/*
 * Copyright 2018 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.tutorialEventsInteractions.events;

import org.terasology.engine.entitySystem.event.Event;

/**
 * Event which triggers a message to be printed to the console.
 *
 * The message must be provided in the constructor and is stored in
 * the event. The message cannot be changed once the event is created.
 */
public class ConsoleEvent implements Event {
    /**
     * The message to print
     */
    private String message;

    /**
     * Creates an instance of this event
     *
     * @param message The message that this event will print
     */
    public ConsoleEvent(String message) {
        this.message = message;
    }

    /**
     * Gets the message from within this event
     *
     * @return The message to print
     */
    public String getMessage() {
        return message;
    }
}
