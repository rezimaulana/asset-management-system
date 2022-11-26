import { ExamMaterialDataDto } from "./exam-material.data.dto";

export class ExamMaterialListResDto{
    private _data : ExamMaterialDataDto[] = []

    public get data(): ExamMaterialDataDto[] {
        return this._data;
    }

    public set data(data: ExamMaterialDataDto[]) {
        this._data = data;
    }

}