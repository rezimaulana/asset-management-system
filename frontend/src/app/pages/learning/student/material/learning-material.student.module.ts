import { NgModule } from "@angular/core";
import { LearningMaterialRoutingStudent } from "./learning-material.student.routing";
import { LearningMaterialDetailComponentStudent } from "./detail/learning-material-detail.student.component";
import { CommonModule } from "@angular/common";

@NgModule({
    declarations : [
        LearningMaterialDetailComponentStudent
    ],
    imports : [
        LearningMaterialRoutingStudent, CommonModule
    ],
    exports : [
        LearningMaterialDetailComponentStudent
    ]
})

export class LearningMaterialModuleStudent{}