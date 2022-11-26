import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { LearningScheduleRoutingStudent } from "./learning-schedule.student.routing";
import { LearningScheduleListComponentStudent } from "./list/learning-schedule-list.student.component";

@NgModule({
    declarations : [
        LearningScheduleListComponentStudent
    ],
    imports : [
        LearningScheduleRoutingStudent, CommonModule
    ],
    exports : [
        LearningScheduleListComponentStudent
    ]
})

export class LearningScheduleModuleStudent{}