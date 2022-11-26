import { NgModule } from "@angular/core";
import { QuizMaterialRoutingInstructor } from "./quiz-material.instructor.routing";
import { QuizMaterialDetailComponentInstructor } from "./detail/quiz-material-detail.instructor.component";
import { QuizMaterialInsertComponentInstructor } from "./insert/quiz-material-insert.instructor.component";
import { QuizMaterialListComponentInstructor } from "./list/quiz-material-list.instructor.component";

@NgModule({
    declarations : [
        QuizMaterialListComponentInstructor, QuizMaterialInsertComponentInstructor, QuizMaterialDetailComponentInstructor
    ],
    imports : [
        QuizMaterialRoutingInstructor
    ],
    exports : [
        QuizMaterialListComponentInstructor, QuizMaterialInsertComponentInstructor, QuizMaterialDetailComponentInstructor
    ]
})

export class QuizMaterialModuleInstructor{}