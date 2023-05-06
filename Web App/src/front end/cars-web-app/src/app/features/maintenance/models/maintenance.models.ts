export interface MaintenanceDTO {
    maintenanceID: number;
    difficulty: string;
    urgency: string;
    description: string;
    mechanicID: number;
    carID: number;
}

export interface MaintenanceAddDTO {
    difficulty: string;
    urgency: string;
    description: string;
}

export interface MaintenanceNoIDDTO {
    difficulty: string;
    urgency: string;
    description: string;
    mechanicID: number;
    carID: number;
}