import { NgModule } from "@angular/core";
import { QuizCollectionRoutingStudent } from "./quiz-collection.student.routing";
import { QuizCollectionInsertComponentStudent } from "./insert/quiz-collection-insert.student.component";
import { FormsModule } from "@angular/forms";
import { CommonModule } from "@angular/common";

@NgModule({
    declarations : [
        QuizCollectionInsertComponentStudent
    ],
    imports : [
        QuizCollectionRoutingStudent, CommonModule, FormsModule
    ],
    exports : [
        QuizCollectionInsertComponentStudent
    ]
})

export class QuizCollectionModuleStudent{}