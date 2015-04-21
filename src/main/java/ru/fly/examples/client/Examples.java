/*
 * Copyright 2015 Valeriy Filatov.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package ru.fly.examples.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.ui.RootPanel;
import ru.fly.client.log.Log;
import ru.fly.client.ui.panel.Viewport;

/**
 * User: fil
 * Date: 16.09.13
 * Time: 10:35
 */
public class Examples implements EntryPoint {
    @Override
    public void onModuleLoad() {
        Log.setUncaughtExceptionHandler();
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                Viewport viewport = new Viewport();
                viewport.add(new MainPanel());
                RootPanel.get().add(viewport);
            }
        });
    }
}
