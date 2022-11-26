import { NgModule } from "@angular/core";
import { ExamMaterialRoutingStudent } from "./exam-material.student.routing";
import { ExamMaterialDetailComponentStudent } from "./detail/exam-material-detail.student.component";
import { CommonModule } from "@angular/common";

@NgModule({
    declarations : [
        ExamMaterialDetailComponentStudent
    ],
    imports : [
        ExamMaterialRoutingStudent, CommonModule
    ],
    exports : [
        ExamMaterialDetailComponentStudent
    ]
})

export class ExamMaterialModuleStudent{}