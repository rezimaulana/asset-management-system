import { NgModule } from "@angular/core";
import { ExamMaterialRoutingInstructor } from "./exam-material.instructor.routing";
import { ExamMaterialDetailComponentInstructor } from "./detail/exam-material-detail.instructor.component";
import { ExamMaterialInsertComponentInstructor } from "./insert/exam-material-insert.instructor.component";
import { ExamMaterialListComponentInstructor } from "./list/exam-material-list.instructor.component";
import { CommonModule } from "@angular/common";
import { FormsModule } from "@angular/forms";

@NgModule({
    declarations : [
        ExamMaterialListComponentInstructor, ExamMaterialInsertComponentInstructor, ExamMaterialDetailComponentInstructor
    ],
    imports : [
        ExamMaterialRoutingInstructor, CommonModule, FormsModule
    ],
    exports : [
        ExamMaterialListComponentInstructor, ExamMaterialInsertComponentInstructor, ExamMaterialDetailComponentInstructor
    ]
})

export class ExamMaterialModuleInstructor{}