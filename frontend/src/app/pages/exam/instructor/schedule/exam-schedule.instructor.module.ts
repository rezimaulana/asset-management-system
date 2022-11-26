import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { ExamScheduleRoutingInstructor } from "./exam-schedule.instructor.routing";
import { ExamScheduleInsertComponentInstructor } from "./insert/exam-schedule-insert.instructor.component";
import { ExamScheduleListComponentInstructor } from "./list/exam-schedule-list.instructor.component";

@NgModule({
    declarations : [
        ExamScheduleListComponentInstructor, ExamScheduleInsertComponentInstructor
    ],
    imports : [
        ExamScheduleRoutingInstructor, CommonModule, FormsModule
    ],
    exports : [
        ExamScheduleListComponentInstructor, ExamScheduleInsertComponentInstructor
    ]
})

export class ExamScheduleModuleInstructor{}