import { NgModule } from "@angular/core";
import { LearningAttendanceRoutingInstructor } from "./learning-attendance.instructor.routing";
import { LearningAttendanceListComponentInstructor } from "./list/learning-attendance-list.instructor.component";

@NgModule({
    declarations : [
        LearningAttendanceListComponentInstructor
    ],
    imports : [
        LearningAttendanceRoutingInstructor
    ],
    exports : [
        LearningAttendanceListComponentInstructor
    ]
})

export class LearningAttendanceModuleInstructor{}