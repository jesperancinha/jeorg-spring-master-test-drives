package org.jesperancinha.smtd.furniture.service

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.jesperancinha.smtd.furniture.exceptions.CaseException
import org.jesperancinha.smtd.furniture.model.Case
import org.jesperancinha.smtd.furniture.repository.CaseRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
open class CaseService(
    open val caseRepository: CaseRepository
) {

    fun getAll(): MutableList<Case> = caseRepository.findAll()

    fun getById(id: Long): Case? = caseRepository.findByIdOrNull(id)

    @Transactional(readOnly = true, propagation = Propagation.NESTED, rollbackFor = [CaseException::class])
    open fun insertFailCase(case: Case) {
        caseRepository.save(case)
        throw CaseException("FailCase")
    }

    @Transactional
    open fun insertCase(case: Case) = caseRepository.save(case)

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW, rollbackFor = [CaseException::class])
    open fun insertCaseStartOneTransactional(case: Case) {
        caseRepository.save(case)
        try {
            insertFailCase(case)

        } catch (caseException: CaseException) {
            ConsolerizerComposer.outSpace()
                .green(caseException)
                .reset()
            caseRepository.findAll().forEach {
                println(it)
            }
            throw caseException
        }
    }

    @Transactional(
        readOnly = true,
        propagation = Propagation.REQUIRES_NEW,
        rollbackFor = [CaseException::class]
    )
    open fun insertCaseFail(case: Case): Nothing {
        caseRepository.save(case)
        throw CaseException("fail!")
    }

    fun deleteCase(id: Long) = caseRepository.deleteById(id)

    fun updateCase(Case: Case) = caseRepository.save(Case)

    fun weightOfAllCases(): Long {
        val Cases = getAll()
        return Cases.map { it.weight }.fold(0L) { sum, item -> sum + (item ?: 0) }
    }
}