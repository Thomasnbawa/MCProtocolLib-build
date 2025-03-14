package org.geysermc.mcprotocollib.protocol.data.game.item.component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.cloudburstmc.nbt.NbtMap;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class AdventureModePredicate {
    private final List<BlockPredicate> predicates;
    private final boolean showInTooltip;

    public AdventureModePredicate(List<BlockPredicate> predicates, boolean showInTooltip) {
        this.predicates = List.copyOf(predicates);
        this.showInTooltip = showInTooltip;
    }

    @Data
    @Builder(toBuilder = true)
    public static class BlockPredicate {
        private final @Nullable HolderSet blocks;
        private final @Nullable List<PropertyMatcher> properties;
        private final @Nullable NbtMap nbt;

        public BlockPredicate(@Nullable HolderSet blocks, @Nullable List<PropertyMatcher> properties, @Nullable NbtMap nbt) {
            this.blocks = blocks;
            this.properties = properties != null ? List.copyOf(properties) : null;
            this.nbt = nbt;
        }
    }

    @Data
    @Builder(toBuilder = true)
    @AllArgsConstructor
    public static class PropertyMatcher {
        private final String name;
        private final @Nullable String value;
        private final @Nullable String minValue;
        private final @Nullable String maxValue;
    }
}
