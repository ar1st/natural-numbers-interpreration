package tree;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TreeTest {

    @Test
    void testRoot() {
        Tree tree = new Tree();

        tree.add("69");

        Assertions.assertThat(tree)
                  .returns("69", it -> it.getRoot().getValue());
    }

    @Test
    void testOneDigitNumbers_ShouldBeSetOnTheLeft() {
        Tree tree = new Tree();

        tree.add("69");
        tree.add("8");
        tree.add("4");
        tree.add("5");

        Assertions.assertThat(tree)
                  .returns("69", it -> it.getRoot().getValue())
                  .returns("8", it -> it.getRoot().getLeft().getValue())
                  .returns("4", it -> it.getRoot().getLeft().getLeft().getValue())
                  .returns("5", it -> it.getRoot().getLeft().getLeft().getLeft().getValue());
    }

    @Test
    void testTwoDigitNumbersWithZero_ZeroShouldBeSetOnTheRight() {
        Tree tree = new Tree();

        tree.add("69");
        tree.add("8");
        tree.add("40");
        tree.add("5");

        Assertions.assertThat(tree)
                  .returns("69", it -> it.getRoot().getValue())
                  .returns("8", it -> it.getRoot().getLeft().getValue())
                  .returns("4", it -> it.getRoot().getLeft().getLeft().getValue())
                  .returns("0", it -> it.getRoot().getLeft().getLeft().getRight().getValue())
                  .returns("5", it -> it.getRoot().getLeft().getLeft().getLeft().getValue());
    }

    @Test
    void testTwoDigitNumbers_ZeroShouldBeSetOnTheRight() {
        Tree tree = new Tree();

        tree.add("69");
        tree.add("8");
        tree.add("47");
        tree.add("5");

        Assertions.assertThat(tree)
                  .returns("69", it -> it.getRoot().getValue())
                  .returns("8", it -> it.getRoot().getLeft().getValue())
                  .returns("4", it -> it.getRoot().getLeft().getLeft().getValue())
                  .returns("0", it -> it.getRoot().getLeft().getLeft().getRight().getValue())
                  .returns("7", it -> it.getRoot().getLeft().getLeft().getLeft().getValue())
                  .returns("5", it -> it.getRoot().getLeft().getLeft().getLeft().getLeft().getValue());
    }
}