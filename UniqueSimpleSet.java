public class UniqueSimpleSet extends SimpleSet {

    public UniqueSimpleSet() {}

    public UniqueSimpleSet(UniqueSimpleSet set) {
        this.addAll(set);
    }

    public void add(String e) {
        if (!contains(e)) {
            super.add(e);
        }
    }

    public void addAll(UniqueSimpleSet newSet) {
        for (String value : newSet.array) {
            add(value);
        }
    }

    public UniqueSimpleSet copy() {
        UniqueSimpleSet newSet = new UniqueSimpleSet();
        newSet.addAll(this);
        return newSet;
    }

    public UniqueSimpleSet union(UniqueSimpleSet set) {
        UniqueSimpleSet newSet = copy();
        newSet.addAll(set);
        return newSet;
    }

    public UniqueSimpleSet intersections(UniqueSimpleSet set) {
        UniqueSimpleSet newSet = copy();
        for (String value : this.array) {
            if (!set.contains(value)) {
                newSet.remove(value);
            }
        }
        return newSet;
    }

    public UniqueSimpleSet complements(UniqueSimpleSet set) {
        UniqueSimpleSet newSet = copy();
        for (String value : set.array) {
            newSet.remove(value);
        }
        return newSet;
    }

    public UniqueSimpleSet difference(UniqueSimpleSet set) {
        UniqueSimpleSet unionSet = union(set);
        UniqueSimpleSet intersectionSet = intersections(set);
        for (String value : intersectionSet.array) {
            unionSet.remove(value);
        }        
        return unionSet;
    }
}
