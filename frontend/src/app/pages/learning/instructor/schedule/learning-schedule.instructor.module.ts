import { NgModule } from "@angular/core";
import { LearningScheduleRoutingInstructor } from "./learning-schedule.instructor.routing";
import { LearningScheduleInsertComponentInstructor } from "./insert/learning-schedule-insert.instructor.component";
import { LearningScheduleListComponentInstructor } from "./list/learning-schedule-list.instructor.component";

@NgModule({
    declarations : [
        LearningScheduleListComponentInstructor, LearningScheduleInsertComponentInstructor
    ],
    imports : [
        LearningScheduleRoutingInstructor
    ],
    exports : [
        LearningScheduleListComponentInstructor, LearningScheduleInsertComponentInstructor
    ]
})

export class LearningScheduleModuleInstructor{}