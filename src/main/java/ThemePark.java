import attractions.Attraction;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;

import java.util.*;
import java.util.stream.Collectors;

public class ThemePark {

    private List<IReviewed> reviewedItems;

    public ThemePark() {
        this.reviewedItems = new ArrayList<>();
    }

    public void addReviewedItem(IReviewed item) {
        reviewedItems.add(item);
    }

    public int getAllReviewed() {
        return reviewedItems.size();
    }


    public void visit(Visitor visitor, Attraction attraction) {
        visitor.addVisited(attraction);
        attraction.increaseVisitCount();
    }

    public Map<String, Integer> getReviews() {
        Map<String, Integer> result = new HashMap<>();
        reviewedItems.forEach(entry -> result.put(entry.getName(), entry.getRating()));
        return result;
    }

    public List<IReviewed> getAllowedFor(Visitor visitor) {
        List<IReviewed> result = reviewedItems.stream()
                .filter(item -> !(item instanceof ISecurity) || ((ISecurity) item).isAllowedTo(visitor) )
                .collect(Collectors.toList());
        return result;
    }
}
