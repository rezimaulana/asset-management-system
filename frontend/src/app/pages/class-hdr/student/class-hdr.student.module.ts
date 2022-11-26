import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { ClassHdrRoutingStudent } from "./class-hdr.student.routing";
import { ClassHdrListComponentStudent } from "./list/class-hdr-list.student.component";

@NgModule({
    declarations : [
        ClassHdrListComponentStudent
    ],
    imports : [
        ClassHdrRoutingStudent, CommonModule, FormsModule
    ],
    exports : [
        ClassHdrListComponentStudent
    ]
})

export class ClassHdrModuleStudent{}