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

package org.terasology.tutorialEventsInteractions.systems;

import org.terasology.engine.entitySystem.entity.EntityRef;
import org.terasology.engine.entitySystem.event.EventPriority;
import org.terasology.engine.entitySystem.event.ReceiveEvent;
import org.terasology.engine.entitySystem.systems.BaseComponentSystem;
import org.terasology.engine.entitySystem.systems.RegisterMode;
import org.terasology.engine.entitySystem.systems.RegisterSystem;
import org.terasology.engine.logic.common.ActivateEvent;
import org.terasology.engine.logic.console.Console;
import org.terasology.engine.registry.In;
import org.terasology.tutorialEventsInteractions.components.ConsoleComponent;
import org.terasology.tutorialEventsInteractions.events.ConsoleEvent;

/**
 * This system demonstrates both sending and receiving events.
 */
@RegisterSystem(RegisterMode.AUTHORITY)
public class TutorialSystem extends BaseComponentSystem {

    /**
     * Used to print to in-game console
     */    
    @In
    private Console console;
    
    /**
     * Receives the activation event (from the player pressing e) first
     * and sends a {@link ConsoleEvent} to print to the console
     *
     * @param event The activate event
     * @param entity The entity being targeted
     * @param comp The relevant component
     */
    @ReceiveEvent(priority=EventPriority.PRIORITY_CRITICAL)
    public void onActivateFirst(ActivateEvent event, EntityRef entity, ConsoleComponent comp) {
        entity.send(new ConsoleEvent("This prints first!"));
    }
    
    /**
     * Receives the activation event (from the player pressing e) last
     * and sends a {@link ConsoleEvent} to print to the console
     *
     * @param event The activate event
     * @param entity The entity being targeted
     * @param comp The relevant component
     */
    @ReceiveEvent(priority=EventPriority.PRIORITY_TRIVIAL)
    public void onActivateLast(ActivateEvent event, EntityRef entity, ConsoleComponent comp) {
        entity.send(new ConsoleEvent("This prints last!"));
    }

    /**
     * Prints messages to the console whenever the event is received
     *
     * @param event The console event, which contains the message
     * @param entity The entity sending the event
     */
    @ReceiveEvent(components={ConsoleComponent.class})
    public void onConsole(ConsoleEvent event, EntityRef entity) {
        console.addMessage(event.getMessage());
    }
}
