import { NgModule } from "@angular/core";
import { QuizCollectionRoutingInstructor } from "./quiz-collection.instructor.routing";
import { QuizCollectionListComponentInstructor } from "./list/quiz-collection-list.instructor.component";
import { QuizCollectionUpdateComponentInstructor } from "./update/quiz-collection-update.instructor.component";

@NgModule({
    declarations : [
        QuizCollectionListComponentInstructor, QuizCollectionUpdateComponentInstructor
    ],
    imports : [
        QuizCollectionRoutingInstructor
    ],
    exports : [
        QuizCollectionListComponentInstructor, QuizCollectionUpdateComponentInstructor
    ]
})

export class QuizCollectionModuleInstructor{}