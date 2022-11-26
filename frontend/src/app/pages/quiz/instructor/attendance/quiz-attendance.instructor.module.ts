import { NgModule } from "@angular/core";
import { QuizAttendanceRoutingInstructor } from "./quiz-attendance.instructor.routing";
import { QuizAttendanceListComponentInstructor } from "./list/quiz-attendance-list.instructor.component";

@NgModule({
    declarations : [
        QuizAttendanceListComponentInstructor
    ],
    imports : [
        QuizAttendanceRoutingInstructor
    ],
    exports : [
        QuizAttendanceListComponentInstructor
    ]
})

export class QuizAttendanceModuleInstructor{}