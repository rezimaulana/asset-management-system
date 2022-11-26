import { NgModule } from "@angular/core";
import { ExamCollectionRoutingInstructor } from "./exam-collection.instructor.routing";
import { ExamCollectionListComponentInstructor } from "./list/exam-collection-list.instructor.component";
import { ExamCollectionUpdateComponentInstructor } from "./update/exam-collection-update.instructor.component";

@NgModule({
    declarations : [
        ExamCollectionListComponentInstructor, ExamCollectionUpdateComponentInstructor
    ],
    imports : [
        ExamCollectionRoutingInstructor
    ],
    exports : [
        ExamCollectionListComponentInstructor, ExamCollectionUpdateComponentInstructor
    ]
})

export class ExamCollectionModuleInstructor{}