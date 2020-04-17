package by.ngrudnitsky.mentoring.homework3.task3.service;

import by.ngrudnitsky.mentoring.homework3.task3.beans.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class PositionService {
    private Set<Position> positions = new HashSet<>();

    public Set<Position> getAllPositions(){
        return positions;
    }

    public Position read(String name) {
        List<Position> position = positions.stream()
                .filter(p -> p.getName().equals(name))
                .collect(Collectors.toList());

        if (position.isEmpty()) {
            return null;
        }
        return position.get(0);
    }

    public boolean create(Position position) {
        if (position != null) {
            return positions.add(position);
        }
        return false;
    }

    public boolean update(Position position) {
        if (position != null) {
            delete(read(position.getName()));
            return create(position);
        }
        return false;
    }

    public boolean delete(Position position) {
        if (position != null) {
            return positions.remove(position);
        }
        return false;
    }

}
