import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { ClassHdrRoutingInstructor } from "./class-hdr.instructor.routing";
import { ClassHdrDetailComponentInstructor } from "./detail/class-hdr-detail.instructor.component";
import { ClassHdrListComponentInstructor } from "./list/class-hdr-list.instructor.component";

@NgModule({
    declarations : [
        ClassHdrListComponentInstructor, ClassHdrDetailComponentInstructor
    ],
    imports : [
        ClassHdrRoutingInstructor, CommonModule
    ],
    exports : [
        ClassHdrListComponentInstructor, ClassHdrDetailComponentInstructor
    ]
})

export class ClassHdrModuleInstructor{}