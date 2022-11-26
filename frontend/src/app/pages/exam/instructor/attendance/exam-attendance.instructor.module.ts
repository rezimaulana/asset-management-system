import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { ExamAttendanceRoutingInstructor } from "./exam-attendance.instructor.routing";
import { ExamAttendanceListComponentInstructor } from "./list/exam-attendance-list.instructor.component";

@NgModule({
    declarations : [
        ExamAttendanceListComponentInstructor
    ],
    imports : [
        ExamAttendanceRoutingInstructor, CommonModule, FormsModule
    ],
    exports : [
        ExamAttendanceListComponentInstructor
    ]
})

export class ExamAttendanceModuleInstructor{}