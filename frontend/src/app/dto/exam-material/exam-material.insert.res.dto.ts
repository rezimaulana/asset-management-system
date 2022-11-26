import { ExamMaterialInsertDataResDto } from "./exam-material.insert.data.res.dto";

export class ExamMaterialInsertResDto{
    private _data! : ExamMaterialInsertDataResDto
	private _message! : string

    public get data(): ExamMaterialInsertDataResDto {
        return this._data;
    }

    public set data(data: ExamMaterialInsertDataResDto) {
        this._data = data;
    }

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }

}