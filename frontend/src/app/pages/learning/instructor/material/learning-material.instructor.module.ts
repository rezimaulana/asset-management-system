import { NgModule } from "@angular/core";
import { LearningMaterialRoutingInstructor } from "./learning-material.instructor.routing";
import { LearningMaterialDetailComponentInstructor } from "./detail/learning-material-detail.instructor.component";
import { LearningMaterialInsertComponentInstructor } from "./insert/learning-material-insert.instructor.component";
import { LearningMaterialListComponentInstructor } from "./list/learning-material-list.instructor.component";

@NgModule({
    declarations : [
        LearningMaterialListComponentInstructor, LearningMaterialInsertComponentInstructor, LearningMaterialDetailComponentInstructor
    ],
    imports : [
        LearningMaterialRoutingInstructor
    ],
    exports : [
        LearningMaterialListComponentInstructor, LearningMaterialInsertComponentInstructor, LearningMaterialDetailComponentInstructor
    ]
})

export class LearningMaterialModuleInstructor{}