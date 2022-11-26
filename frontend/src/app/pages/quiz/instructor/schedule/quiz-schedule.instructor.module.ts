import { NgModule } from "@angular/core";
import { QuizScheduleRoutingInstructor } from "./quiz-schedule.instructor.routing";
import { QuizScheduleInsertComponentInstructor } from "./insert/quiz-schedule-insert.instructor.component";
import { QuizScheduleListComponentInstructor } from "./list/quiz-schedule-list.instructor.component";

@NgModule({
    declarations : [
        QuizScheduleListComponentInstructor, QuizScheduleInsertComponentInstructor
    ],
    imports : [
        QuizScheduleRoutingInstructor
    ],
    exports : [
        QuizScheduleListComponentInstructor, QuizScheduleInsertComponentInstructor
    ]
})

export class QuizScheduleModuleInstructor{}