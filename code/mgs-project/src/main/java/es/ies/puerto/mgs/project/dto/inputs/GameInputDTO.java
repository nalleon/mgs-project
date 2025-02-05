package es.ies.puerto.mgs.project.dto.inputs;

import java.util.List;

public record GameInputDTO (String name, List<Integer> charactersIds, String director) {
}
