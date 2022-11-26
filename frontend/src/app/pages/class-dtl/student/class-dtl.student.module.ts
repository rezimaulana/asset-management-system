import { NgModule } from "@angular/core";
import { ClassDtlRoutingStudent } from "./class-dtl.student.routing";
import { ClassDtlListComponentStudent } from "./list/class-dtl-list.student.component";
import { ClassDtlDetailComponentStudent } from "./detail/class-dtl-detail.student.component";
import { CommonModule } from "@angular/common";

@NgModule({
    declarations : [
        ClassDtlListComponentStudent, ClassDtlDetailComponentStudent
    ],
    imports : [
        ClassDtlRoutingStudent, CommonModule
    ],
    exports : [
        ClassDtlListComponentStudent, ClassDtlDetailComponentStudent
    ]
})

export class ClassDtlModuleStudent{}