import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { ExamScheduleRoutingStudent } from "./exam-schedule.student.routing";
import { ExamScheduleListComponentStudent } from "./list/exam-schedule-list.student.component";

@NgModule({
    declarations : [
        ExamScheduleListComponentStudent
    ],
    imports : [
        ExamScheduleRoutingStudent, CommonModule
    ],
    exports : [
        ExamScheduleListComponentStudent
    ]
})

export class ExamScheduleModuleStudent{}