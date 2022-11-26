import { NgModule } from "@angular/core";
import { QuizScheduleRoutingStudent } from "./quiz-schedule.student.routing";
import { QuizScheduleListComponentStudent } from "./list/quiz-schedule-list.student.component";
import { CommonModule } from "@angular/common";

@NgModule({
    declarations : [
        QuizScheduleListComponentStudent
    ],
    imports : [
        QuizScheduleRoutingStudent, CommonModule
    ],
    exports : [
        QuizScheduleListComponentStudent
    ]
})

export class QuizScheduleModuleStudent{}