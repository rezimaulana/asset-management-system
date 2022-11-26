import { NgModule } from "@angular/core";
import { QuizMaterialRoutingStudent } from "./quiz-material.student.routing";
import { QuizMaterialDetailComponentStudent } from "./detail/quiz-material-detail.student.component";
import { CommonModule } from "@angular/common";

@NgModule({
    declarations : [
        QuizMaterialDetailComponentStudent
    ],
    imports : [
        QuizMaterialRoutingStudent, CommonModule
    ],
    exports : [
        QuizMaterialDetailComponentStudent
    ]
})

export class QuizMaterialModuleStudent{}