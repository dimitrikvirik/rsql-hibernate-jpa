package com.github.ichanzhar.rsql

import cz.jirutka.rsql.parser.ast.AndNode
import cz.jirutka.rsql.parser.ast.ComparisonNode
import cz.jirutka.rsql.parser.ast.OrNode
import cz.jirutka.rsql.parser.ast.RSQLVisitor
import org.springframework.data.jpa.domain.Specification

class JpaRsqlVisitor<E> : RSQLVisitor<Specification<E>, Void?> {
	private val builder: GenericRsqlSpecBuilder<E> = GenericRsqlSpecBuilder()

	override fun visit(node: AndNode, param: Void?): Specification<E> {
		return builder.createSpecification(node)
	}

	override fun visit(node: OrNode, param: Void?): Specification<E>? {
		return builder.createSpecification(node)
	}

	override fun visit(node: ComparisonNode, params: Void?): Specification<E>? {
		return builder.createSpecification(node)
	}
}