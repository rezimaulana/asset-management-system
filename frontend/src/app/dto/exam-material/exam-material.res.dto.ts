import { ExamMaterialDataDto } from "./exam-material.data.dto";

export class ExamMaterialResDto{
    private _data : ExamMaterialDataDto = new ExamMaterialDataDto

    public get data(): ExamMaterialDataDto {
        return this._data;
    }

    public set data(data: ExamMaterialDataDto) {
        this._data = data;
    }

}