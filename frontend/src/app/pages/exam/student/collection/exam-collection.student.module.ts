import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { ExamCollectionRoutingStudent } from "./exam-collection.student.routing";
import { ExamCollectionInsertComponentStudent } from "./insert/exam-collection-insert.student.component";

@NgModule({
    declarations : [
        ExamCollectionInsertComponentStudent
    ],
    imports : [
        ExamCollectionRoutingStudent, CommonModule, FormsModule
    ],
    exports : [
        ExamCollectionInsertComponentStudent
    ]
})

export class ExamCollectionModuleStudent{}